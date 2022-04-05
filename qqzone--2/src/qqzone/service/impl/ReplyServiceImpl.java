package qqzone.service.impl;

import qqzone.dao.ReplyDAO;
import qqzone.pojo.HostReply;
import qqzone.pojo.Reply;
import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;
import qqzone.service.HostReplyService;
import qqzone.service.ReplyService;
import qqzone.service.UserBasicService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListByTopicId(Integer topicTId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicTId));

        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            //1、设置每个reply的author
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);

            //2、设置每个reply相关联的hostReply
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }
}
