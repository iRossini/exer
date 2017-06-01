package com.luoxin.sssp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.luoxin.sssp.entities.Credential;

@Repository
public class CredentialsDao {
	@PersistenceContext
	private EntityManager entityManager;

	// 通过Id删除一份证书
	public void delete(Integer id) {
		String hql = "DELETE FROM Credential c where c.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// 通过ID查询一份证书
	public Credential getCredentialById(Integer id) {
		String hql = "FROM Credential c left outer join fetch c.cusInstrument where c.id=?";
		return (Credential) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}

	// 查询所有证书
	@SuppressWarnings("unchecked")
	public List<Credential> getAll() {
		String hql = "FROM Credential e left outer join fetch e.cusINstrument ";
		return entityManager.createQuery(hql).getResultList();
	}

}
