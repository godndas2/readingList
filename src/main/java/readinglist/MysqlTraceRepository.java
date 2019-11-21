package readinglist;

import com.sun.deploy.trace.Trace;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MysqlTraceRepository implements TraceRepository {

    // TODO MongoOperations to Mysql version

    @Override
    public List<Trace> findAll() {
        return null;
    }

    @Override
    public void add(Map<String, Object> traceInfo) {

    }
}
