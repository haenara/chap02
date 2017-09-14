package com.example.mapper;

import static org.junit.Assert.*;

import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("oracle")
public class DeptMapperTest {
	
	@Inject
	DeptMapper deptMapper;

	@Test
	public void selectAll() {
		List<Dept> list = deptMapper.selectAll();
		assertThat(list, is(notNullValue()));
		System.out.println(deptMapper.getClass());
//		list.forEach(new Consumer<Dept>() {
//
//			@Override
//			public void accept(Dept t) {
//				
//			}
//		});
		list.forEach(e ->{
			System.out.println(e);
		});
		
	}

}
