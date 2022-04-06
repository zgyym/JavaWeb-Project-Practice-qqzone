package qqzone.service.impl;

import qqzone.dao.HostReplyDAO;
import qqzone.pojo.HostReply;
import qqzone.service.HostReplyService;

public class HostReplyServiceImpl implements HostReplyService {

    private HostReplyDAO hostReplyDAO;
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByHostReplyId(replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.deleteHostReplyById(id);
    }
}
