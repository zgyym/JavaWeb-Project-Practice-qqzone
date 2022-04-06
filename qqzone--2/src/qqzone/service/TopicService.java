package qqzone.service;

import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic) ;
    //根据id查询获取特定的topic
    Topic getTopicById(Integer id);
    //根据id获取指定的topic信息，包括与topic关联的作者的所有信息
    Topic getTopic(Integer id);
    //删除topic
    void delTopic(Integer id);
}
