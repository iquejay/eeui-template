/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
#pragma once

#if ENABLE(DFG_JIT)

#include <wtf/AutomaticThread.h>
#include <wtf/Lock.h>

namespace JSC { namespace DFG {

class Safepoint;
class Worklist;

class ThreadData {
    WTF_MAKE_FAST_ALLOCATED;
public:
    ThreadData(Worklist*);
    ~ThreadData();
    
private:
    friend class Safepoint;
    friend class Worklist;
    
    Worklist* m_worklist;
    RefPtr<AutomaticThread> m_thread;
    Lock m_rightToRun;
    Safepoint* m_safepoint;
};

} } // namespace JSC::DFG

#endif // ENABLE(DFG_JIT)
