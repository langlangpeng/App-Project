package com.team.appinfo.service.impl;

import com.team.appinfo.entity.DataDictionary;
import com.team.appinfo.mapper.DataDictionaryMapper;
import com.team.appinfo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;
    @Override
    public List<DataDictionary> getDictionary(String typename) {
        return this.dataDictionaryMapper.getDataDictionaryInfo(typename);
    }
}
