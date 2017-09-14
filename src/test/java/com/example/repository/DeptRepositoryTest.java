package com.example.repository;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;


@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("mysql-ec2")
@ActiveProfiles("oracle")
//@DataJpaTest //순수하게 인젝트만 테스트함 HyperSQL Database 검색해서 받기.
public class DeptRepositoryTest {
	
	@Inject
	DeptRepository deptRepository;

	@Test
	   public void insert() {
	      System.out.println(deptRepository.getClass());
	      deptRepository.save(new Dept(new BigInteger("10"), "경리부x", "Seoul"));
	      
	      System.out.println(deptRepository.findOne(new BigInteger("10")));
	      
	      assertEquals(new Dept(new BigInteger("10"), "경리부x", "Seoul"),
	            deptRepository.findOne(new BigInteger("10")));
//	      assertNull(deptRepository.findOne(new BigInteger("10")));
	   }

	   @Test
	   public void update() {
	      System.out.println(deptRepository.getClass());
	      deptRepository.save(new Dept(new BigInteger("10"), "경리부", "Seoul"));
	      deptRepository.save(new Dept(new BigInteger("10"), "경리부x", "Seoulx"));
	      
	      System.out.println(deptRepository.findOne(new BigInteger("10")));
	      
	      assertEquals(new Dept(new BigInteger("10"), "경리부x", "Seoulx"),
	            deptRepository.findOne(new BigInteger("10")));
	   }
	   
	   @Test
	   public void delete() {
	      System.out.println(deptRepository.getClass());
	      deptRepository.save(new Dept(new BigInteger("10"), "경리부", "Seoul"));
	      deptRepository.save(new Dept(new BigInteger("10"), "경리부x", "Seoulx"));
	      deptRepository.delete(new BigInteger("10"));
	      
	      
	      try {
	    	  System.out.println(deptRepository.findOne(new BigInteger("10")));
		} catch (DataIntegrityViolationException e) {

			e.getMessage();
			e.printStackTrace();
			return;
		}
	      
	      
	      assertNull(deptRepository.findOne(new BigInteger("10")));
	   }
	   
	   @Test
	   public void selectAll() {
	      System.out.println(deptRepository.getClass());
	      Dept d10 = new Dept(new BigInteger("10"), "경리부", "서울");
	      Dept d20 = new Dept(new BigInteger("20"), "인사부", "인천");
	      Dept d30 = new Dept(new BigInteger("30"), "영업부", "용인");
	      Dept d40 = new Dept(new BigInteger("40"), "전산부", "수원");
	      
	      deptRepository.save(d10);
	      deptRepository.save(d20);
	      deptRepository.save(d30);
	      deptRepository.save(d40);
	      
	      deptRepository.findAll().forEach(e -> {
	         System.out.println(e);
	      });
	   }
	   
	   @Test
	   public void selectAll2() {
	      System.out.println(deptRepository.getClass());
	      Dept d10 = new Dept(new BigInteger("10"), "경리부", "Seoul");
	      Dept d20 = new Dept(new BigInteger("20"), "인사부", "인천");
	      Dept d30 = new Dept(new BigInteger("30"), "영업부", "용인");
	      Dept d40 = new Dept(new BigInteger("40"), "전산부", "수원");
	      
	      	List<Dept> list = Arrays.asList(d10,d20,d30,d40);
	      	deptRepository.save(list);
	      	
	      	assertThat(deptRepository.findAll(), is(list));
	      	      
	      deptRepository.findAll().forEach(e -> {
	         System.out.println(e);
	      });
	   }
	
	
}
