/**
 * Copyright 2012 Lyncode
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lyncode.xoai.common.dataprovider.sets;

import java.util.List;

import com.lyncode.xoai.common.dataprovider.core.Set;
import com.lyncode.xoai.common.dataprovider.filter.AbstractFilter;



/**
 * @author DSpace @ Lyncode
 * @version 2.0.0
 */
public class StaticSet extends Set {
    private List<AbstractFilter> _filters;

    public StaticSet (List<AbstractFilter> filters, String spec, String name) {
        super(spec, name);
        _filters = filters;
    }

    public List<AbstractFilter> getFilters() {
        return _filters;
    }
}