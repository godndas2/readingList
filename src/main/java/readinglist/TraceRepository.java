package readinglist;

import com.sun.deploy.trace.Trace;

import java.util.List;
import java.util.Map;

public interface TraceRepository {

    // TODO Trace 해당 class 가 맞는지?
    List<Trace> findAll();

    void add(Map<String, Object> traceInfo);
}
