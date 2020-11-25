package board.services;

import board.domains.ArticleDTO;
import board.domains.ReplyDTO;

public interface ArticleService{
    public void writeArticle(ArticleDTO article);
    public void modifyArticle(ArticleDTO article);
    public void removeArticle(ArticleDTO article);
    public void writeReply(ReplyDTO reply);
    public void removeReply(ReplyDTO reply);
    public ArticleDTO readArticle(int artId);
    public ReplyDTO[] readReply(int artId);    
}