package com.example.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
@ActiveProfiles("mysql")
public class EmpRepositoryTest {

	@Inject
	EmpRepository empRepository;
	
	@Before
	public void before() throws ParseException{
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		empRepository.save(new Emp(new BigInteger("1001"), "김사랑", Emp.Gender.F,
				"사원", 1013, f.parse("2007-03-01"), new BigDecimal(300), null,20 ));
		empRepository.save(new Emp(new BigInteger("1002"), "한예슬", Emp.Gender.F,
				"대리", 1005, f.parse("2007-04-02"), new BigDecimal(250), new BigDecimal(80),30 ));
		empRepository.save(new Emp(new BigInteger("1003"), "오지호", Emp.Gender.M,
				"과장", 1005, f.parse("2005-02-10"), new BigDecimal(500), new BigDecimal(100),30 ));
		empRepository.save(new Emp(new BigInteger("1004"), "이병헌", Emp.Gender.M,
				"과장", 1008, f.parse("2003-09-02"), new BigDecimal(600), null, 20 ));
		empRepository.save(new Emp(new BigInteger("1005"), "신동협", Emp.Gender.M,
				"과장", 1005, f.parse("2005-04-07"), new BigDecimal(450), new BigDecimal(200),30 ));
		empRepository.save(new Emp(new BigInteger("1006"), "장동건", Emp.Gender.M,
				"과장", 1008, f.parse("2003-10-09"), new BigDecimal(480), null,30 ));
		empRepository.save(new Emp(new BigInteger("1007"), "이문세", Emp.Gender.M,
				"부장", 1008, f.parse("2004-01-08"), new BigDecimal(520), null,10 ));
		empRepository.save(new Emp(new BigInteger("1008"), "감우성", Emp.Gender.M,
				"차장", 1003, f.parse("2004-03-08"), new BigDecimal(500), new BigDecimal(0),30 ));
		empRepository.save(new Emp(new BigInteger("1009"), "안성기", Emp.Gender.M,
				"사장", null, f.parse("1996-10-04"), new BigDecimal(1000), null,20 ));
		empRepository.save(new Emp(new BigInteger("1010"), "이병헌", Emp.Gender.M,
				"과장", 1003, f.parse("2005-04-07"), new BigDecimal(500), null,10 ));
		empRepository.save(new Emp(new BigInteger("1011"), "조향기", Emp.Gender.F,
				"사원", 1007, f.parse("2007-03-01"), new BigDecimal(280), null,30 ));
		empRepository.save(new Emp(new BigInteger("1012"), "강혜정", Emp.Gender.F,
				"사원", 1006, f.parse("2007-08-09"), new BigDecimal(300), null,30 ));
		empRepository.save(new Emp(new BigInteger("1013"), "박중훈", Emp.Gender.M,
				"부장", 1003, f.parse("2002-10-09"), new BigDecimal(560), null,20 ));
		empRepository.save(new Emp(new BigInteger("1014"), "조인성", Emp.Gender.M,
				"사원", 1003, f.parse("2007-11-09"), new BigDecimal(250), null,10 ));
	}
//	INSERT INTO EMP VALUES(1001, '김사랑', 'F','사원', 1013, to_date('2007-03-01','yyyy-mm-dd'), 300, NULL, 20);
	@Test
	public void test() {
		
		empRepository.findAll().forEach(e ->{
			System.out.println(e);
		});
	}

	@Test
	public void deleteAll(){
		
		empRepository.deleteAll();
		assertThat(empRepository.findAll(), CoreMatchers.is(Collections.emptyList()));
		
	}
	
}
