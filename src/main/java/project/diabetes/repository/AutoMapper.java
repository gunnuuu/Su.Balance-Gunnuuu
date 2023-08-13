package project.diabetes.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AutoMapper {
    List<Map<String, Object>> autocomplete(Map<String, Object> paramMap) throws Exception;
}
