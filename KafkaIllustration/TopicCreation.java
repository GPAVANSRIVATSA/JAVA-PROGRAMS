package springKafka.springKafkaDemo.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicCreation {
	@Bean
	public NewTopic createTopic()
	{
		return TopicBuilder.name("demonstration").build();
	}
	@Bean
	public NewTopic createTopicForJson()
	{
		return TopicBuilder.name("example").build();
	}
	@Bean
	public NewTopic createTopicForKey()
	{
		return TopicBuilder.name("illustrate").build();
	}
	@Bean 
	public NewTopic createTopicForPartition()
	{
		return new NewTopic("illustration",3,(short)1);
	}
	

}
