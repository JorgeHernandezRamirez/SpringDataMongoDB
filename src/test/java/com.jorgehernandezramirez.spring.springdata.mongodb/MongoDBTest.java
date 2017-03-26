package com.jorgehernandezramirez.spring.springdata.mongodb;

import com.jorgehernandezramirez.spring.springdata.mongodb.configuration.MongoDBConfiguration;
import com.jorgehernandezramirez.spring.springdata.mongodb.entity.Count;
import com.jorgehernandezramirez.spring.springdata.mongodb.entity.UserEntity;
import com.jorgehernandezramirez.spring.springdata.mongodb.entity.UserGenderCount;
import com.jorgehernandezramirez.spring.springdata.mongodb.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertNotNull;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoDBConfiguration.class,loader=AnnotationConfigContextLoader.class)
public class MongoDBTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBTest.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldBeNotNullMongoTemplate(){
        assertNotNull(mongoTemplate);
        assertNotNull(userRepository);
    }

    @Test
    public void shouldReturnAllUsersFromDB(){
        userRepository.findAll().forEach(userEntity -> {
            LOGGER.info("{}", userEntity);
        });
    }

    @Test
    public void shouldReturnAllUsersFromUsername(){
        userRepository.findByName("Jorge").forEach(userEntity -> {
            LOGGER.info("{}", userEntity);
        });
    }

    @Test
    public void shouldReturnAllUsersLikeUDLasPalmas(){
        userRepository.findByTeamname("UD. Las Palmas").forEach(userEntity -> {
            LOGGER.info("{}", userEntity);
        });
    }

    @Test
    public void shouldGetNumberOfMenAndWomens(){
        final Aggregation aggregation = newAggregation(
                group("gender").count().as("count"),
                project("count").and("gender").previousOperation());
        final AggregationResults<UserGenderCount> groupResults
                = mongoTemplate.aggregate(aggregation, UserEntity.class, UserGenderCount.class);
        LOGGER.info("{}", groupResults.getMappedResults());
    }

    @Test
    public void shouldGetNumberRealMadridLikers(){
        final Aggregation aggregation = newAggregation(
                unwind("teams"),
                match(Criteria.where("teams.name").is("Real Madrid")),
                group().count().as("count"),
                project("count"));
        final AggregationResults<Count> groupResults
                = mongoTemplate.aggregate(aggregation, UserEntity.class, Count.class);
        LOGGER.info("{}", groupResults.getMappedResults());
    }
}
