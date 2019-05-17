package cn.twt.controller;

import cn.twt.entity.Page;
import cn.twt.service.EdocEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/edoc")
public class EdocEntryController {
    @Resource
    private EdocEntryService edocEntryService;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "categoryId",required = false)Integer categoryId,
                       @RequestParam(value = "pageNo",required = false)Integer pageNo, Model model){
        pageNo = pageNo == null ? 1 : pageNo;
        pageNo = pageNo == 0 ? 1 : pageNo;
        Page page = new Page();
        page.setTotaCount(edocEntryService.EdocEntryCount());
        pageNo = pageNo >= page.getTotaPageCount() ? page.getTotaPageCount() : pageNo;
        page.setCurrPageNo(pageNo);
        model.addAttribute("edocEntryList",edocEntryService.queryEdocEntryPageList((pageNo-1)*page.getPageSize(),page.getPageSize(),categoryId));
        model.addAttribute("edocCategoryList",edocEntryService.queryEdocCategoryAll());
        model.addAttribute("categoryId",categoryId);
        model.addAttribute("page",page);
        return "/EdocEntryList";
    }
    @RequestMapping("/del/{id}")
    @ResponseBody
    public String del(@PathVariable Integer id){
        if (edocEntryService.delEdocEntry(id)>0){
            return "true";
        }
        return "false";   12345679879879798
    }
}
