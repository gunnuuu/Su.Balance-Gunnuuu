package project.diabetes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.diabetes.repository.AutoMapper;

import java.util.Map;
import java.util.List;


@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    AutoMapper autoMapper;

    @Override
    public List<Map<String, Object>> autocomplete(Map<String, Object> paramMap) throws Exception{
        return autoMapper.autocomplete(paramMap);
    }


}
