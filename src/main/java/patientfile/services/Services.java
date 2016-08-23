package patientfile.services;

import java.util.List;

/**
 * Created by chantell witbooi on 8/22/2016.
 */
public interface Services<S,ID> {

    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
}
