package com.rm.pattern.creation._3_Prototype;

import java.util.HashMap;
import java.util.List;

/**
 * Object.clone() 浅拷贝
 * @author chenrong
 * @version 1.0
 * @since 2021/6/30
 **/
public class 浅拷贝 {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // 原型模式就这么简单，拷贝已有对象的数据，更新少量差值
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();

        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }

    public static class SearchWord{
        public SearchWord(){}
        public SearchWord(String keyword, int count, long lastUpdateTime){
        }
        public long getLastUpdateTime(){
            return 0L;
        }
        public String getKeyword() {
            return "";
        }
        public void setCount(int count) {
        }
        public int getCount() {
            return 0;
        }
        public void setLastUpdateTime(long lastUpdateTime) {
        }
    }
}
