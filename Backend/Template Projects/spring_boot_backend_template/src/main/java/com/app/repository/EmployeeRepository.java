package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	


//Jparepo extends PagingAndSortingRepo which extends CrudRepo which extends Repository which 
	//exposes methods to 
	// perform crud operations(findById(), save(), saveAll(), existById()..etc)
	
	//Implementation class of JpaRepositoryImplemetation (I) is SimpleJpaRepository(class)
	// JpaRepositoryImplementation extends JpaRepository
	//SimpleRepository class implements JpaRepositoryImplemntation(I)
	//Impl class(SimpleRepository(C)) of JpaRepository is already annotated with @Repository
	//hence, no need of annotation @Repository
	//Also SimpleJpaRepository class annotated with @Transactional 
	
	
}
