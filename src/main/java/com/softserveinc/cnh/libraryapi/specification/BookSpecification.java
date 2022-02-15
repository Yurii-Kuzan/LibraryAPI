package com.softserveinc.cnh.libraryapi.specification;

import com.softserveinc.cnh.libraryapi.model.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

public class BookSpecification implements Specification<Book> {

    private final Map<String, Object> attributes;

    private BookSpecification(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public static BookSpecification create(Map<String, Object> attributes) {
        return new BookSpecification(attributes);
    }


    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return new BookPredicateBuilder(criteriaBuilder, root)
                .title((String) attributes.get("title"))
                .author((String) attributes.get("author"))
                .year((Integer) attributes.get("year"))
                .inStockNumber((Integer) attributes.get("in_stock_number"))
                .takenBooksNumber((Integer) attributes.get("taken_books_number"))
                .build();
    }


    private static class BookPredicateBuilder {
        private final List<Predicate> predicates;
        private final CriteriaBuilder criteriaBuilder;
        private final Root<Book> root;

        BookPredicateBuilder(CriteriaBuilder criteriaBuilder, Root<Book> root) {
            this.predicates = new ArrayList<>();
            this.criteriaBuilder = criteriaBuilder;
            this.root = root;
        }

        BookPredicateBuilder id(Long id) {
            if (nonNull(id)) {
                predicates.add(criteriaBuilder.equal(root.get("id"), id));
            }
            return this;
        }

        BookPredicateBuilder title(String title) {
            if (nonNull(title)) {
                predicates.add(criteriaBuilder.equal(root.get("title"), title));
            }
            return this;
        }

        BookPredicateBuilder author(String author) {
            if (nonNull(author)) {
                predicates.add(criteriaBuilder.equal(root.get("author"), author));
            }
            return this;
        }

        BookPredicateBuilder year(Integer year) {
            if (nonNull(year)) {
                predicates.add(criteriaBuilder.equal(root.get("year"), year));
            }
            return this;
        }

        BookPredicateBuilder inStockNumber(Integer inStockNumber) {
            if (nonNull(inStockNumber)) {
                predicates.add(criteriaBuilder.equal(root.get("in_stock_number"), inStockNumber));
            }
            return this;
        }

        BookPredicateBuilder takenBooksNumber(Integer takenBooksNumber) {
            if (nonNull(takenBooksNumber)) {
                predicates.add(criteriaBuilder.equal(root.get("taken_books_number"), takenBooksNumber));
            }
            return this;
        }

        @SuppressWarnings("all")
        Predicate build() {
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        }
    }
}
