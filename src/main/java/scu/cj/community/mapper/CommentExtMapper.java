package scu.cj.community.mapper;

import scu.cj.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}