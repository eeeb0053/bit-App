package board.controllers;

import board.domains.ArticleDTO;
import board.domains.ReplyDTO;
import board.impls.ArticleServiceImpl;
import board.services.ArticleService;

public class ArticleController {
    private ArticleService articleService;
    public ArticleController(){
        articleService = new ArticleServiceImpl();
    }
    public void postArticle(ArticleDTO article){
        articleService.writeArticle(article);
    }
    public void updateArticle(ArticleDTO article){
        articleService.modifyArticle(article);
    }
    public void deleteArticle(ArticleDTO article){
        articleService.removeArticle(article);
    }
    public void postReply(ReplyDTO reply){
        articleService.writeReply(reply);
    }
    public void deleteReply(ReplyDTO reply){
        articleService.removeReply(reply);
    }
    public ArticleDTO getArticle(int artId){
        return articleService.readArticle(artId);
    }
    public ReplyDTO[] getReply(int artId){
        return articleService.readReply(artId);
    } 
}



















