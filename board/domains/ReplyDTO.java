package board.domains;

public class ReplyDTO extends ArticleDTO{
    private int replyId;
    public int getBoardId() {
        return replyId;
    }
    public void setBoardId(int replyId) {
        this.replyId = replyId;
    }

    /*
    public boolean equals(Object o) {
        if(o instanceof ReplyDTO) {
            ReplyDTO r = (ReplyDTO)o;
            if(id == r.id) {
                return true;
            }
        }
        
        return false;
    }
    */
}




















