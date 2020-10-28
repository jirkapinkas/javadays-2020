package com.example.helloworld.entity.priklad2;

import javax.persistence.*;

@NamedEntityGraph(
        name = Employee.GRAPH_PHONE,
        attributeNodes = {
                @NamedAttributeNode(value = "phone", subgraph = "brand")
        }, subgraphs = {
        @NamedSubgraph(name = "brand", attributeNodes = @NamedAttributeNode("brand"))
})
@Entity
public class Employee {

    public static final String GRAPH_PHONE = "graph.Employee.phone";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
