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

    @Override
    public void delReply(Integer id) {
        //1、获取reply
        Reply reply = replyDAO.getReplyById(id);
        if(reply != null){
            //2、如果reply由关联的hostReply，先删除hostReply
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if(hostReply != null){
                hostReplyService.delHostReply(hostReply.getId());
            }
            //删除reply
            replyDAO.delReply(id);
        }

    }

    @Override
    public void delReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        if(replyList != null){
            for(Reply reply : replyList){
                delReply(reply.getId());
            }
        }
    }


}
