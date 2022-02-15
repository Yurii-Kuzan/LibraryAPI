package com.softserveinc.cnh.libraryapi.specification;

import com.softserveinc.cnh.libraryapi.model.Reader;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

public class ReaderSpecification implements Specification<Reader> {

    private final Map<String, Object> attributes;

    private ReaderSpecification(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public static ReaderSpecification create(Map<String, Object> attributes) {
        return new ReaderSpecification(attributes);
    }


    @Override
    public Predicate toPredicate(Root<Reader> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    private static class ReaderPredicateBuilder {
        private final List<Predicate> predicates;
        private final CriteriaBuilder criteriaBuilder;
        private final Root<Reader> root;

        ReaderPredicateBuilder(CriteriaBuilder criteriaBuilder, Root<Reader> root) {
            this.predicates = new ArrayList<>();
            this.criteriaBuilder = criteriaBuilder;
            this.root = root;
        }

        ReaderSpecification.ReaderPredicateBuilder id(Long id) {
            if (nonNull(id)) {
                predicates.add(criteriaBuilder.equal(root.get("id"), id));
            }
            return this;
        }

        ReaderSpecification.ReaderPredicateBuilder firstName(String firstName) {
            if (nonNull(firstName)) {
                predicates.add(criteriaBuilder.equal(root.get("first_name"), firstName));
            }
            return this;
        }

        ReaderSpecification.ReaderPredicateBuilder secondName(String secondName) {
            if (nonNull(secondName)) {
                predicates.add(criteriaBuilder.equal(root.get("second_name"), secondName));
            }
            return this;
        }

        ReaderSpecification.ReaderPredicateBuilder address(String address) {
            if (nonNull(address)) {
                predicates.add(criteriaBuilder.equal(root.get("address"), address));
            }
            return this;
        }

        ReaderSpecification.ReaderPredicateBuilder age(Integer age) {
            if (nonNull(age)) {
                predicates.add(criteriaBuilder.equal(root.get("age"), age));
            }
            return this;
        }

        ReaderSpecification.ReaderPredicateBuilder inStockNumber(Integer inStockNumber) {
            if (nonNull(inStockNumber)) {
                predicates.add(criteriaBuilder.equal(root.get("in_stock_number"), inStockNumber));
            }
            return this;
        }

        ReaderSpecification.ReaderPredicateBuilder takenBooksNumber(Integer takenBooksNumber) {
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
