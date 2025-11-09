package iuh.fit.se.dao;

import jakarta.persistence.EntityManager;
import iuh.fit.se.entity.DienThoai;
import iuh.fit.se.entity.NhaCungCap;
import iuh.fit.se.util.JpaUtil;

import java.util.List;

public class DienthoaiDao {
    public List<DienThoai> findByNcc(int maNcc) {
        EntityManager em = JpaUtil.getEm();
        try {
            return em.createQuery("SELECT d FROM DienThoai d WHERE d.ncc.mancc = :id",
                            DienThoai.class)
                    .setParameter("id", maNcc)
                    .getResultList();
        } finally { em.close(); }
    }

    public void insert(DienThoai dt) {
        EntityManager em = JpaUtil.getEm();
        try {
            em.getTransaction().begin();
            em.persist(dt);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void delete(int madt) {
        EntityManager em = JpaUtil.getEm();
        try {
            em.getTransaction().begin();
            DienThoai dt = em.find(DienThoai.class, madt);
            if (dt != null) em.remove(dt);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public NhaCungCap findNcc(int mancc) {
        EntityManager em = JpaUtil.getEm();
        try {
            return em.find(NhaCungCap.class, mancc);
        } finally { em.close(); }
    }
}
