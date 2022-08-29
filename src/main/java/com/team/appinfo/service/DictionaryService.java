package com.team.appinfo.service;

import com.team.appinfo.entity.DataDictionary;

import java.util.List;

public interface DictionaryService {
    public List<DataDictionary> getDictionary(String typename);
}
