package com.fastcampus.jpa.bookmanager.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Martin
 * @since 2021/04/21
 */
@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Publisher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
    For orphan removal: If you invoke setOrders(null), the related Order entities will be removed in db automatically.
    For remove cascade: If you invoke setOrders(null), the related Order entities will NOT be removed in db automatically.
    */
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
    }
}
