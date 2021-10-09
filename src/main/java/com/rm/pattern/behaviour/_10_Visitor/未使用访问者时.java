package com.rm.pattern.behaviour._10_Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果工具的功能不停地扩展，不仅要能抽取文本内容，还要支持压缩、提取文件元信息（文件名、大小、更新时间等等）构建索引等一系列的功能
 */
public class 未使用访问者时 {


    public abstract static class ResourceFile {
        protected String filePath;

        public ResourceFile(String filePath) {
            this.filePath = filePath;
        }

        public abstract void extract2txt();
    }

    public static class PPTFile extends ResourceFile {
        public PPTFile(String filePath) {
            super(filePath);
        }

        @Override
        public void extract2txt() {
            //...省略一大坨从PPT中抽取文本的代码...
            //...将抽取出来的文本保存在跟filePath同名的.txt文件中...
            System.out.println("Extract PPT.");
        }
    }

    public static class PdfFile extends ResourceFile {
        public PdfFile(String filePath) {
            super(filePath);
        }

        @Override
        public void extract2txt() {
            //...
            System.out.println("Extract PDF.");
        }
    }

    public static class WordFile extends ResourceFile {
        public WordFile(String filePath) {
            super(filePath);
        }

        @Override
        public void extract2txt() {
            //...
            System.out.println("Extract WORD.");
        }
    }

    // 运行结果是：
// Extract PDF.
// Extract WORD.
// Extract PPT.
    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.extract2txt();
        }
    }

    private static List<ResourceFile> listAllResourceFiles() {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }

}
