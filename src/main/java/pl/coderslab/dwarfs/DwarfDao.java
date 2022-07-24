package pl.coderslab.dwarfs;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DwarfDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Dwarf> findDwarfs() {
        Query query = entityManager.createQuery("select d from Dwarf d");
        List resultList = query.getResultList();
        return resultList;
    }

    public List<Dwarf> findDwarfs2() {
        return entityManager.createQuery("select d from Dwarf d")
                .getResultList();
    }

    public void save(Dwarf dwarf) {
        entityManager.persist(dwarf);
    }

    public Dwarf findById(Long id) {
        return entityManager.find(Dwarf.class, id);
    }

    public void update(Dwarf dwarf) {
        entityManager.merge(dwarf);
    }

    public void delete(Dwarf dwarf) {
        entityManager.remove(entityManager.contains(dwarf) ?
                dwarf : entityManager.merge(dwarf));
    }
}
