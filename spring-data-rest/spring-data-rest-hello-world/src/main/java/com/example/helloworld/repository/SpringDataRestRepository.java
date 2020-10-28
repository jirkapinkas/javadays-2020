package com.example.helloworld.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.MultiValueBinding;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Optional;

/**
 * Just low level Repository (extends Repository)
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface SpringDataRestRepository<T, ID> extends Repository<T, ID>, QuerydslPredicateExecutor<T>, QuerydslBinderCustomizer {

    @Override
    default void customize(QuerydslBindings bindings, EntityPath root) {
        // https://stackoverflow.com/questions/35155824/can-spring-data-rests-querydsl-integration-be-used-to-perform-more-complex-quer

        /*
         * Search for LocalDateTime. If we search for two local datetimes, then we effectively search between those dates.
         */
        bindings.bind(LocalDateTime.class).all((path, values) -> {
            if(values.size() == 2) {
                Iterator<? extends LocalDateTime> iterator = values.iterator();
                LocalDateTime val1 = iterator.next();
                LocalDateTime val2 = iterator.next();
                DateTimePath<LocalDateTime> dateTimePath = (DateTimePath<LocalDateTime>) path;
                return Optional.of(dateTimePath.between(val1, val2));
            } else {
                BooleanBuilder booleanBuilder = new BooleanBuilder();
                values.forEach(value -> {
                    booleanBuilder.or(((DateTimePath<LocalDateTime>) path).eq(value));
                });
                return Optional.of(booleanBuilder);
            }
        });

        /*
         * Search for Long. If we search for two longs, then we effectively search between two values.
         */
        MultiValueBinding<NumberPath<Long>, Long> longBinding = (path, values) -> {
            if(values.size() == 2) {
                Iterator<? extends Long> iterator = values.iterator();
                Long val1 = iterator.next();
                Long val2 = iterator.next();
                return Optional.of(path.between(val1, val2));
            } else {
                BooleanBuilder booleanBuilder = new BooleanBuilder();
                values.forEach(value -> {
                    booleanBuilder.or(path.eq(value));
                });
                return Optional.of(booleanBuilder);
            }
        };
        bindings.bind(long.class).all(longBinding);
        bindings.bind(Long.class).all(longBinding);

        /*
         * Search for Double. If we search for two doubles, then we effectively search between two values.
         */
        MultiValueBinding<NumberPath<Double>, Double> doubleBinding = (path, values) -> {
            if(values.size() == 2) {
                Iterator<? extends Double> iterator = values.iterator();
                Double val1 = iterator.next();
                Double val2 = iterator.next();
                return Optional.of(path.between(val1, val2));
            } else {
                BooleanBuilder booleanBuilder = new BooleanBuilder();
                values.forEach(value -> {
                    booleanBuilder.or(path.eq(value));
                });
                return Optional.of(booleanBuilder);
            }
        };
        bindings.bind(double.class).all(doubleBinding);
        bindings.bind(Double.class).all(doubleBinding);

        /*
         * Search for Integer. If we search for two integers, then we search between those two values.
         */
        MultiValueBinding<NumberPath<Integer>, Integer> integerBinding = (path, values) -> {
            if(values.size() == 2) {
                Iterator<? extends Integer> iterator = values.iterator();
                Integer val1 = iterator.next();
                Integer val2 = iterator.next();
                return Optional.of(path.between(val1, val2));
            } else {
                BooleanBuilder booleanBuilder = new BooleanBuilder();
                values.forEach(value -> {
                    booleanBuilder.or(path.eq(value));
                });
                return Optional.of(booleanBuilder);
            }
        };
        bindings.bind(Integer.class).all(integerBinding);
        bindings.bind(int.class).all(integerBinding);

        /*
         * Note: correct REST call is having in URL: "%25searchedText%25" instead of "%searchedText%"!!!!!
         * (it's necessary to convert "%" to "%25" - encode string)!!!
         */

        /*
         * Search for Strings: implemented like + case insensitive search
         */
        bindings.bind(String.class).all((path, values) -> {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            values.forEach(value -> {
                if("%".equals(value)) {
                    booleanBuilder.or(((StringPath) path).contains(""));
                } else if(value.startsWith("%") && value.endsWith("%")) {
                    booleanBuilder.or(((StringPath) path).containsIgnoreCase(value.replace("%", "")));
                } else if(value.startsWith("%")) {
                    booleanBuilder.or(((StringPath) path).endsWithIgnoreCase(value.replace("%", "")));
                } else if(value.endsWith("%")) {
                    booleanBuilder.or(((StringPath) path).startsWithIgnoreCase(value.replace("%", "")));
                } else {
                    booleanBuilder.or(((StringPath) path).equalsIgnoreCase(value));
                }
            });
            return Optional.of(booleanBuilder);
        });
    }

}
