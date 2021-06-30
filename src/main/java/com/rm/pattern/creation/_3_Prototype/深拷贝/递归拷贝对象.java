package com.rm.pattern.creation._3_Prototype.深拷贝;

import com.rm.pattern.creation._3_Prototype.浅拷贝;

import java.util.HashMap;
import java.util.List;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/30
 **/
public class 递归拷贝对象 {

    private HashMap<String, 浅拷贝.SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // Deep copy
        HashMap<String, 浅拷贝.SearchWord> newKeywords = new HashMap<>();
        for (HashMap.Entry<String, 浅拷贝.SearchWord> e : currentKeywords.entrySet()) {
            浅拷贝.SearchWord searchWord = e.getValue();
            浅拷贝.SearchWord newSearchWord = new 浅拷贝.SearchWord(
                    searchWord.getKeyword(), searchWord.getCount(), searchWord.getLastUpdateTime());
            newKeywords.put(e.getKey(), newSearchWord);
        }

        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<浅拷贝.SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (浅拷贝.SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                浅拷贝.SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<浅拷贝.SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }

}
