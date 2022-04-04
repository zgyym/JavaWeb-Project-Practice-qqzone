package qqzone.dao.impl;

import myssm.basedao.BaseDAO;
import qqzone.dao.ReplyDAO;
import qqzone.pojo.Reply;
import qqzone.pojo.Topic;

import java.util.List;

public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        return super.executeQuery("select * from t_reply where topic = ? " , topic.getId());
    }

    @Override
    public void addReply(Reply reply) {

    }

    @Override
    public void delReply(Integer id) {

    }
}
