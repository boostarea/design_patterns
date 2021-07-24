package com.rm.pattern.behaviour._10_Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/7/2
 **/
public class 访问者 {

    public abstract static class ResourceFile {
        protected String filePath;

        public ResourceFile(String filePath) {
            this.filePath = filePath;
        }

        abstract public void accept(Visitor vistor);
    }

    public static class PdfFile extends ResourceFile {
        public PdfFile(String filePath) {
            super(filePath);
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public static class PPTFile extends ResourceFile {
        public PPTFile(String filePath) {
            super(filePath);
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public static class WordFile extends ResourceFile {
        public WordFile(String filePath) {
            super(filePath);
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public interface Visitor {
        void visit(PdfFile pdfFile);
        void visit(PPTFile pptFile);
        void visit(WordFile wordFile);
    }

    public static class Extractor implements Visitor {
        @Override
        public void visit(PPTFile pptFile) {
            //...
            System.out.println("Extract PPT.");
        }

        @Override
        public void visit(PdfFile pdfFile) {
            //...
            System.out.println("Extract PDF.");
        }
        @Override
        public void visit(WordFile wordFile) {
            //...
            System.out.println("Extract WORD.");
        }
    }

    public static class Compressor implements Visitor {
        @Override
        public void visit(PPTFile pptFile) {
            //...
            System.out.println("Compress PPT.");
        }

        @Override
        public void visit(PdfFile pdfFile) {
            //...
            System.out.println("Compress PDF.");
        }

        @Override
        public void visit(WordFile wordFile) {
            //...
            System.out.println("Compress WORD.");
        }
    }

    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }

        Compressor compressor = new Compressor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
}
