<#import "common.ftl" as c/>

<@c.page>
    <link rel="stylesheet" type="text/css" href="/css/posts.css">
    <ul>
        <#list posts as p>
            <li>
                <@c.makepost p 1>
                    <ul class="attachment">
                        <li>Announcement of <a href="#">Codeforces Round #510 (Div. 1)</a></li>
                        <li>Announcement of <a href="#">Codeforces Round #510 (Div. 2)</a></li>
                    </ul>
                    <div class="footer">
                        <div class="left">
                            <img src="img/voteup.png" title="Vote Up" alt="Vote Up"/>
                            <span class="positive-score">+173</span>
                            <img src="img/votedown.png" title="Vote Down" alt="Vote Down"/>
                        </div>
                        <div class="right">
                            <img src="img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                            2 days ago
                            <img src="img/comments_16x16.png" title="Comments" alt="Comments"/>
                            <a href="#">68</a>
                        </div>
                    </div>
                </@c.makepost>
            </li>
        </#list>
    </ul>
</@c.page>