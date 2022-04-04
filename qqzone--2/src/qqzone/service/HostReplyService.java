package qqzone.service;

import qqzone.pojo.HostReply;

public interface HostReplyService {
    //根据reply的id获取主人回复
    HostReply getHostReplyByReplyId(Integer replyId);
}
