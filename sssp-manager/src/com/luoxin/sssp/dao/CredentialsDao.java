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

	// ͨ��Idɾ��һ��֤��
	public void delete(Integer id) {
		String hql = "DELETE FROM Credential c where c.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// ͨ��ID��ѯһ��֤��
	public Credential getCredentialById(Integer id) {
		String hql = "FROM Credential c left outer join fetch c.cusInstrument where c.id=?";
		return (Credential) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}

	// ��ѯ����֤��
	@SuppressWarnings("unchecked")
	public List<Credential> getAll() {
		String hql = "FROM Credential e left outer join fetch e.cusINstrument ";
		return entityManager.createQuery(hql).getResultList();
	}

}
