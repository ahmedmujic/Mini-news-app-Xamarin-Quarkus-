package ba.university.project.respository;


import ba.university.project.respository.entity.Blog;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class BlogRepository extends Repository<Blog, Integer> {
    public  BlogRepository(){
        super(Blog.class);
    }

    public List<Blog> allBlogs(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Blog> cq = cb.createQuery(Blog.class);

        Root<Blog> root = cq.from(Blog.class);
        CriteriaQuery<Blog> all = cq.select(root);


        TypedQuery<Blog> allQuery = entityManager.createQuery(all);


        return allQuery.getResultList();
    }

}
