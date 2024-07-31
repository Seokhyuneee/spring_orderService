package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    //자신은 의존관계의 주인이 아닌, Order table에 있는 member 필드에 따라 그저 읽기 전용임을 의미.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}
