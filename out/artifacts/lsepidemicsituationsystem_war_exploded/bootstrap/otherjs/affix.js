!function ($) {

    "use strict"; // jshint ;_;


    /* AFFIX CLASS DEFINITION
    * ====================== */

    var Affix = function (element, options) {
        this.options = setOptions($.extend({}, $.fn.affix.defaults, options));
        this.$window = $(window)
          .on('scroll.affix.data-api', $.proxy(this.checkPosition, this))
          .on('resize.affix.data-api', $.proxy(this.checkPosition, this))
          .on('click.affix.data-api', $.proxy(function () { setTimeout($.proxy(this.checkPosition, this), 1) }, this))
        this.$element = $(element)
        this.checkPosition()
        this.lastTop = this.$window.scrollTop();
    }
    var setOptions = function (data) {
        var options = {};
        options.top = (typeof data.top == 'function') ? data.top : function () { return data.top };
        options.bottom = (typeof data.bottom == 'function') ? data.bottom : function () { return data.bottom };
        options.ceiling = (typeof data.ceiling == 'function') ? data.ceiling : function () { return data.ceiling };
        options.floor = (typeof data.floor == 'function') ? data.floor : function () { return data.floor };
        return options;
    }
    var doScroll = function (elem, delta, top, eHeight, wHeight, dHeight, scrollTop, offset) {
        var topCovered = top - offset.top < 0;
        var bottomCovered = top + eHeight + offset.bottom > wHeight;
        var reachTop = scrollTop < offset.ceiling;
        var reachBottom = dHeight - scrollTop - eHeight - offset.top <= offset.floor;
        var isSmallBlock = wHeight > eHeight + offset.top + offset.bottom;

        var max = 0, move = "none", newTop = top - delta;

        if (reachTop) move = "ceiling";
        else if (reachBottom) move = "floor";
        else if (isSmallBlock) {
            move = "pinTop";
        }
        else {
            if (delta > 0) {
                if (bottomCovered) move = "bottom";
                else move = "none";
            }
            else if (delta < 0) {
                if (topCovered) move = "top";
                else move = "none";
            }
            else {
                move = "pinTop";
            }
        }
        switch (move) {
            case "top":
                max = offset.top;
                newTop = newTop > max ? max : newTop;
                break;
            case "bottom":
                max = wHeight - eHeight - offset.bottom;
                newTop = newTop < max ? max : newTop;
                break;
            case "ceiling":
                max = offset.top;
                newTop = offset.ceiling - scrollTop;
                newTop = newTop < max ? max : newTop;
                break;
            case "floor":
                max = wHeight - eHeight - offset.bottom;
                newTop = dHeight - scrollTop - offset.floor - eHeight;
                newTop = newTop > max ? max : newTop;
                break;
            case "pinTop":
                newTop = offset.top;
                break;
        }
        log(move,newTop)
        if (move != "none") {
            elem.css("top", newTop + "px");
        }
    }

    Affix.prototype.checkPosition = function () {
        if (!this.$element.is(':visible')) return

        var scrollTop = this.$window.scrollTop()
            , currTop = this.$window.scrollTop()
            , top = this.$element.position().top
            , eHeight = this.$element.outerHeight(true)
            , wHeight = $(window).height()
            , dHeight = $(document).height()
            , offset = {};

        offset.top = this.options.top();
        offset.bottom = this.options.bottom();
        offset.ceiling = this.options.ceiling();
        offset.floor = this.options.floor();

        doScroll(this.$element, currTop - this.lastTop, top, eHeight, wHeight, dHeight, scrollTop, offset);
        this.lastTop = currTop;
        return;
    }


    /* AFFIX PLUGIN DEFINITION
    * ======================= */

    var old = $.fn.affix

    $.fn.affix = function (option) {
        return this.each(function () {
            var $this = $(this)
                , data = $this.data('affix')
                , options = typeof option == 'object' && option
            if (!data) $this.data('affix', (data = new Affix(this, options)))
            if (typeof option == 'string') data[option]()
        })
    }

    $.fn.affix.Constructor = Affix

    $.fn.affix.defaults = {
        top: 20,
        bottom: 20,
        ceiling: 20,
        floor: 20
    }


    /* AFFIX NO CONFLICT
    * ================= */

    $.fn.affix.noConflict = function () {
        $.fn.affix = old
        return this
    }


    /* AFFIX DATA-API
    * ============== */

    $(window).on('load', function () {
        $('[data-spy="affix"]').each(function () {
            $(this).affix()
        })
    })


} (window.jQuery);