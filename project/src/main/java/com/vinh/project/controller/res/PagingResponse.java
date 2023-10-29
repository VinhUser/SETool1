package com.vinh.project.controller.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagingResponse<T> {
    public int page;
    public int size;
    public int totalPage;
    public long totalItem;
    public List<T> contends;
}
