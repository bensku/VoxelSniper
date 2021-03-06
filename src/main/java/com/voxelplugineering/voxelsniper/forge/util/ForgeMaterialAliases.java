/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 The Voxel Plugineering Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.voxelplugineering.voxelsniper.forge.util;

import com.voxelplugineering.voxelsniper.service.alias.AliasHandler;
import com.voxelplugineering.voxelsniper.service.alias.AliasRegistry;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class ForgeMaterialAliases
{
    public static void loadDefaultAliases(AliasHandler registry)
    {

        { // brushes

            if (!registry.hasTarget("material"))
            {
                registry.registerTarget("material");
            }
            AliasRegistry alias = registry.getRegistry("material").get();

            for (Object key : Block.blockRegistry.getKeys())
            {
                Block block = (Block) Block.blockRegistry.getObject(key);
                ResourceLocation rs = (ResourceLocation) key;
                String name = (!rs.getResourceDomain().equals("minecraft") ? rs.getResourceDomain() + ":" : "") + rs.getResourcePath();
                String id = Block.getIdFromBlock(block) + "";
                alias.register(id, name);
            }
        }
    }
}
