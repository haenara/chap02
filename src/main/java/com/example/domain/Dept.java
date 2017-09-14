package com.example.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity   // Hibernate인식
public class Dept {
   
   @Id   // PK... 필수
   @Column(precision=2)
   private BigInteger deptno;
   @Column(length=14, nullable=false)
   private String dname;
   @Column(length=13)
   private String loc;
}