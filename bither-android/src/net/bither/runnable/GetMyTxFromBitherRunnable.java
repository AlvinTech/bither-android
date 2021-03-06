/*
 * Copyright 2014 http://Bither.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.bither.runnable;

import net.bither.bitherj.core.Address;
import net.bither.service.BlockchainService;
import net.bither.util.TransactionsUtil;

import java.util.List;

public class GetMyTxFromBitherRunnable extends BaseRunnable {
    private List<Address> mAddressList;
    private BlockchainService mBlockchainService;
    private int mStoreBlockHeight;

    public GetMyTxFromBitherRunnable(BlockchainService blockchainService,
                                     List<Address> list) {
        this.mBlockchainService = blockchainService;
        this.mAddressList = list;

    }

    @Override
    public void run() {
        obtainMessage(HandlerMessage.MSG_PREPARE);
        try {
            TransactionsUtil.getMyTxFromBither();
            obtainMessage(HandlerMessage.MSG_SUCCESS);
        } catch (Exception e) {
            obtainMessage(HandlerMessage.MSG_FAILURE);
            e.printStackTrace();
        }

    }
}
