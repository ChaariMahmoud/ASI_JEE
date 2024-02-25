package Wrapper_filter_demo;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> parameterMap;

    public CustomHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.parameterMap = new HashMap<>(request.getParameterMap());
    }

    @Override
    public String getParameter(String name) {
        String[] values = parameterMap.get(name);
        return (values != null && values.length > 0) ? values[0] : null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return Collections.unmodifiableMap(parameterMap);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(parameterMap.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return parameterMap.get(name);
    }

    public void setParameter(String name, String value) {
        parameterMap.put(name, new String[]{value});
    }

    public void setParameterValues(String name, String[] values) {
        parameterMap.put(name, values);
    }
}
