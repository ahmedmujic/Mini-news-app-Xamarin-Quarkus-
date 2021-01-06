package ba.university.project.respository;

import ba.university.project.respository.entity.ModelObject;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Repository<T extends ModelObject, PK extends Serializable> {
    private Class<T> entityClass;

    protected Repository(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    @Inject
    EntityManager entityManager;

    public T add(T modelObject)
    {
        modelObject.setCreatedOn(LocalDateTime.now());
        modelObject.setModifiedOn(LocalDateTime.now());
        entityManager.persist(modelObject);
        return modelObject;
    }

    public List<T> addList(List<T> list){

        list.forEach((n) -> {
            n.setCreatedOn(LocalDateTime.now());
            n.setModifiedOn(LocalDateTime.now());
            entityManager.persist(n);

        });
        return list;


    }


    public T findById(PK id)
    {
        T result = entityManager.find(this.entityClass, id);
        if(result != null) {
            return result;
        }
        return null;
    }

    public T save(T modelObject)
    {
        T result = null;
        PK id = (PK)modelObject.getId();
        if(id != null) {
            result = findById(id);
        }
        if(id == null || result!= null) {
            entityManager.persist(modelObject);
            return modelObject;
        }
        return null;
    }
}
