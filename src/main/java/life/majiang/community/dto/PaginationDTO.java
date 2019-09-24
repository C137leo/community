package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean  showPrevious;
    private boolean  showFirstPage;
    private boolean  showNext;
    private boolean  showEndPage;
    //当前页
    private Integer page;
    private Integer totalPage;
    //返回的list数组
    private List<Integer> pages=new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        if(totalCount%size==0){
            totalPage=totalCount/size;
        }else {
            totalPage=totalCount/size+1;
        }

        this.page=page;
        //将当前页加入list
        pages.add(page);
        //进行判断，当前页的前三页，当前页的后三页加入list
        for(int i=1;i<=3;i++){
            if (page-i>0){
                pages.add(0,page-i);
            }
            if (page+i<=totalPage){
                pages.add(page+i);
            }
        }
        //是否显示前一页
        if(page==1){
            showPrevious=false;
        }else {
            showPrevious=true;
        }
        //是否显示后一页
        if(page==totalPage){
            showNext=false;
        }else {
            showNext=true;
        }
        //是否显示首页
        if(pages.contains(1)){
            showFirstPage=false;
        }else {
            showFirstPage=true;
        }
        //是否显示末页
        if(pages.contains(totalPage)){
            showEndPage=false;
        }else {
            showEndPage=true;
        }
    }
}
