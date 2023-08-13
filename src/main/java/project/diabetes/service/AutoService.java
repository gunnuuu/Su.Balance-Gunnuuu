package project.diabetes.service;

import java.util.List;
import java.util.Map;

public interface AutoService {
    List<Map<String, Object>> autocomplete(Map<String, Object> paramMap) throws Exception;
}
