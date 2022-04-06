package qqzone.dao;

import qqzone.pojo.HostReply;

public interface HostReplyDAO {
    HostReply getHostReplyByHostReplyId(Integer replyID);
    //根据id删除指定hostReply
    void deleteHostReplyById(Integer id);
}
