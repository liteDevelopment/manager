package com.handsome.manager.controller;


import com.handsome.manager.ao.DatatablesResult;
import com.handsome.manager.ao.ServiceResault;
import com.handsome.manager.model.Product;
import com.handsome.manager.model.User;
import com.handsome.manager.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author handsome
 * @since 2020-05-11
 */
@Controller
@RequestMapping("/pc/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/dataGrid")
    public ResponseEntity<DatatablesResult> list(Product product,
                                                 @RequestParam(value = "draw") int draw,
                                                 @RequestParam(value = "start") String start,
                                                 @RequestParam(value = "length") String length) {
        int rows = Integer.parseInt(length);
        int page = (Integer.parseInt(start) / rows) + 1;
        List<Product> users = productService.list(rows, page);
        DatatablesResult pageResult = new DatatablesResult<Product>();
        pageResult.setData(users);
        pageResult.setDraw(draw);
        pageResult.setRecordsTotal(productService.count());
        pageResult.setRecordsFiltered(pageResult.getRecordsTotal());
        return ResponseEntity.ok(pageResult);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResault> delete(@RequestParam(value = "id") String id) {
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        productService.del(id);
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ServiceResault> save(Product product) {
        if (StringUtils.isEmpty(product.getId())) {
            productService.add(product);
        } else {
            productService.update(product);
        }
        return ResponseEntity.ok(new ServiceResault());
    }

    @RequestMapping(value = "/select")
    public ResponseEntity<ServiceResault> select() {
        return ResponseEntity.ok(productService.select());
    }

    @RequestMapping(value = "/query")
    public ResponseEntity<ServiceResault> query(String id) {
        return ResponseEntity.ok(productService.query(id));
    }
}

