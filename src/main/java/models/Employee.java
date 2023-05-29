package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    // первичный ключ
    @Id
    // для того чтобы Hibernate лучше понимал, как присваивать ID объектам
    // Hibernate делегирует установку ID на уровень базы данных
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;

    // ManyToOne является стороной-владельцем в двунаправленных связях
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    public Employee(String first_name, String last_name, String gender, int age, City city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }


}
