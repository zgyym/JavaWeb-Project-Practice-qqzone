package qqzone.dao.impl;

import myssm.basedao.BaseDAO;
import qqzone.dao.HostReplyDAO;
import qqzone.pojo.HostReply;

public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByHostReplyId(Integer replyId) {
        return super.load("select * from t_host_reply where reply = ? " , replyId);
    }

    @Override
    public void deleteHostReplyById(Integer id) {
        super.executeUpdate("delete from t_host_reply where id = ?", id);
    }
}
